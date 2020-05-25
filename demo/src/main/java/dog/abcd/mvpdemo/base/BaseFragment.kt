package dog.abcd.mvpdemo.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import dog.abcd.fastmvp.IDisposableHandler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment : Fragment(), IDisposableHandler, IBaseView {

    val TAG = javaClass.simpleName

    override var compositeDisposable: CompositeDisposable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun getContext(): Context? {
        return super.getContext()
    }

    override fun getLifecycleOwner(): LifecycleOwner? {
        return this
    }

    override fun getBundle(): Bundle? {
        return arguments
    }

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }

}