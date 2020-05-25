package dog.abcd.mvpdemo.presenter

import dog.abcd.fastmvp.FastPresenter
import dog.abcd.mvpdemo.view.IMainView

class MainPresenter2 : FastPresenter<IMainView>() {

    override fun onBindView() {
        view?.getBtnMain()?.setOnClickListener {
            view?.showToast("nice2")
        }
    }

}