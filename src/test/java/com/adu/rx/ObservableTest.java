package com.adu.rx;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author duyunjie
 * @date 2018/7/23 下午3:30
 */
public class ObservableTest extends BaseTest {
    @Test
    public void subscribe() {
        Observable<Long> source = Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> observableEmitter) throws Exception {
                long i = 0L;
                while (true) {
                    observableEmitter.onNext(i++);
                    if (i == 5) {
                        throw new RuntimeException();
                    }

                    Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
                }
            }
        });

        source.window(1, TimeUnit.SECONDS).subscribe(window -> window.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                //每个window开始时
                logger.info("[onSubscribe]disposable={}", disposable);
            }

            @Override
            public void onNext(Long aLong) {
                //窗口期接收数据
                logger.info("[onNext]aLong={}", aLong);
            }

            @Override
            public void onError(Throwable throwable) {
                //窗口处理抛出异常的处理
                logger.info("[onError]", throwable);
            }

            @Override
            public void onComplete() {
                //窗口正常结束时
                logger.info("[onComplete]");
            }
        }));

        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }
}
