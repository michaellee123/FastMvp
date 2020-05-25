package dog.abcd.mvpdemo.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import dog.abcd.fastmvp.FastPresenter
import dog.abcd.fastmvp.IFastMVP

abstract class BaseMvpFragment<K : IBaseView, T : FastPresenter<K>> : BaseFragment(), IFastMVP<K, T> {
    override lateinit var presenter: T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindPresenter()
    }

    override fun lifecycle(): Lifecycle = lifecycle
}