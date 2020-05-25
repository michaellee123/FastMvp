package dog.abcd.mvpdemo.presenter

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import dog.abcd.fastmvp.FastPresenter
import dog.abcd.mvpdemo.view.ITestView
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TestPresenter : FastPresenter<ITestView>() {
    @SuppressLint("SetTextI18n")
    override fun onBindView() {
        view?.getTextView()?.text = "onBind"
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.e(TAG,"onResume")
        view?.showToast("onResume")
    }
}