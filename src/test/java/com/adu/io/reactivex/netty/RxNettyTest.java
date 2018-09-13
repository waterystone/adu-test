package com.adu.io.reactivex.netty;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.base.Charsets;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.reactivex.netty.RxNetty;
import io.reactivex.netty.channel.ConnectionHandler;
import io.reactivex.netty.channel.ObservableConnection;
import io.reactivex.netty.server.ErrorHandler;
import rx.Observable;

/**
 * @author duyunjie
 * @date 2018/9/13 下午2:36
 */
public class RxNettyTest extends BaseTest {
    private static final int PORT = 28860;
    private MyConnectionHandler myConnectionHandler = new MyConnectionHandler();
    private MyErrorHandler myErrorHandler = new MyErrorHandler();

    /**
     * 测试方法:$telnet localhost 28860
     */
    @Test
    public void createTcpServer() {
        RxNetty.createTcpServer(PORT, myConnectionHandler).start();
        sleepUninterruptibly();
    }

    /**
     * 测试方法:$telnet localhost 28860
     */
    @Test
    public void newTcpServerBuilder() {
        RxNetty.newTcpServerBuilder(PORT, myConnectionHandler).build().withErrorHandler(myErrorHandler).start();
        sleepUninterruptibly();
    }

    private class MyConnectionHandler implements ConnectionHandler<ByteBuf, ByteBuf> {

        @Override
        public Observable<Void> handle(ObservableConnection<ByteBuf, ByteBuf> observableConnection) {

            return observableConnection.getInput().flatMap(byteBuf -> {
                String msg = new String(ByteBufUtil.getBytes(byteBuf), Charsets.UTF_8);
                logger.info("receive message,msg={}", msg);

                if (msg.startsWith("hello")) {
                    throw new RuntimeException("just Exception");
                }

                String response = "[ACK]" + msg;
                ByteBuf responseByteBuf = Unpooled.wrappedBuffer(response.getBytes(Charsets.UTF_8));
                observableConnection.writeAndFlush(responseByteBuf);

                return Observable.empty();
            });
        }
    }

    private class MyErrorHandler implements ErrorHandler {

        @Override
        public Observable<Void> handleError(Throwable throwable) {
            logger.error("[exception-handler]", throwable);
            return Observable.empty();
        }
    }
}
