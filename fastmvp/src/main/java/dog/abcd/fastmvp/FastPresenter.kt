package dog.abcd.fastmvp

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.disposables.CompositeDisposable

/**
 * <b>FastPresenter</b><br>
 * 通过继承此类来自定义自己的presenter
 *
 * @author michaellee <br> create at 2020/5/25 16:12
 */
abstract class FastPresenter<T : IFastView> : DefaultLifecycleObserver, IDisposableHandler {

    val TAG = javaClass.simpleName

    override var compositeDisposable: CompositeDisposable? = null

    protected var view: T? = null

    fun bind(view: T) {
        this.view = view
        onBindView()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        detach()
    }

    private fun detach() {
        compositeDisposable?.clear()
        this.view = null
    }

    abstract fun onBindView()

}