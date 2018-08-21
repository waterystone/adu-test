package com.adu.io.netty.bootstrap;

import com.adu.BaseTest;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/8/21 下午7:51
 */
public class BootStrapTest extends BaseTest {
    private int port = 28860;
    private MyChannelInitializer myChannelInitializer = new MyChannelInitializer();
    private MyChannelHandler myChannelHandler = new MyChannelHandler();

    @Test
    public void boot() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group).channel(NioDatagramChannel.class).handler(myChannelInitializer);

        // 绑定端口，开始接收进来的连接
        ChannelFuture channelFuture = bootstrap.bind(port).sync();

        // 等待关闭
        channelFuture.channel().closeFuture().await();
    }

    class MyChannelInitializer extends ChannelInitializer<NioDatagramChannel> {

        @Override
        protected void initChannel(NioDatagramChannel nioDatagramChannel) throws Exception {
            nioDatagramChannel.pipeline().addLast("handler", myChannelHandler);
        }
    }

    class MyChannelHandler extends SimpleChannelInboundHandler<DatagramPacket> {

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket)
                throws Exception {
            ByteBuf byteBuf = datagramPacket.content();
            byte[] contentBytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(contentBytes);
            String content = new String(contentBytes);
            logger.info("content={}", content);

            ByteBuf data = Unpooled.buffer(1);
            data.writeByte(1);
            channelHandlerContext.writeAndFlush(new DatagramPacket(data, datagramPacket.sender()));
        }
    }
}
