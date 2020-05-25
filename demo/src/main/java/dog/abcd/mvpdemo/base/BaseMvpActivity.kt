package dog.abcd.mvpdemo.base

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import dog.abcd.fastmvp.FastPresenter
import dog.abcd.fastmvp.IFastMVP

abstract class BaseMvpActivity<K : IBaseView, T : FastPresenter<K>> : BaseActivity(),IFastMVP<K,T> {

    override lateinit var presenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindPresenter()
    }

    override fun lifecycle(): Lifecycle = lifecycle

}