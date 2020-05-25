package dog.abcd.mvpdemo.presenter

import android.content.Intent
import dog.abcd.fastmvp.FastPresenter
import dog.abcd.mvpdemo.view.IMainView
import dog.abcd.mvpdemo.view.activity.TestActivity
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter : FastPresenter<IMainView>() {

    override fun onBindView() {
        view?.getBtnMain()?.setOnClickListener {
            view?.showToast("nice")
            val intent = Intent()
            intent.setClass(view?.getContext()!!,TestActivity::class.java)
            view?.getContext()?.startActivity(intent)
        }
    }
}