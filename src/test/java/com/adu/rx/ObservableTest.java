package com.adu.rx;

import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import scala.Int;

/**
 * @author duyunjie
 * @date 2018/7/23 下午3:30
 */
public class ObservableTest extends BaseTest {
    Observable<Integer> observable;
    Observer<Integer> observer;

    @Test
    public void subscribe() {
        observable.subscribe(observer);

        sleepUninterruptibly();
    }

    @Test
    public void subscribe2() {
        Observable.just(1, 2, 3).subscribe(observer);

        sleepUninterruptibly();
    }

    @Test
    public void flatMap() {
        Observable<Integer> objectObservable = Observable.just(1, 2).flatMap(integer -> {
            logger.info("integer={}", integer);

            return Observable.just(-integer, -integer);
        });

        objectObservable.subscribe(observer);

        sleepUninterruptibly();
    }

    @Test
    public void windowSubscribe() {
        observable.window(1, TimeUnit.SECONDS).subscribe(window -> window.subscribe(observer));

        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    @Before
    public void init() {
        observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                int i = 0;
                while (true) {
                    observableEmitter.onNext(i++);
                    if (i == 5) {
                        throw new RuntimeException();
                    }

                    Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
                }
            }
        });

        observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                logger.info("[onSubscribe]disposable={}", disposable);
            }

            @Override
            public void onNext(Integer integer) {
                logger.info("[onNext]integer={}", integer);
            }

            @Override
            public void onError(Throwable throwable) {
                logger.info("[onError]", throwable);
            }

            @Override
            public void onComplete() {
                logger.info("[onComplete]");
            }
        };
    }

}
