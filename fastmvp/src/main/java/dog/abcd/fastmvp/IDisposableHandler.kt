package dog.abcd.fastmvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * <b>rxjava统一取消监听</b><br>
 * 需要用到rxjava的地方实现这个接口，并且在destroy的时候调用compositeDisposable.clear()
 * 推荐在父类中实现
 * ⚠️注意：在每次使用rxjava的时候记得把disposable添加到addDisposable()方法
 *
 * @author michaellee <br> create at 2020/5/25 16:12
 */
interface IDisposableHandler {

    var compositeDisposable: CompositeDisposable?

    fun addDisposable(disposable: Disposable) {
        if (null == compositeDisposable) {
            compositeDisposable = CompositeDisposable()
        }

        if (!compositeDisposable!!.isDisposed) {
            compositeDisposable!!.add(disposable)
        }
    }

}