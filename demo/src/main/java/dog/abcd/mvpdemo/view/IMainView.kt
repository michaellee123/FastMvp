package dog.abcd.mvpdemo.view

import android.widget.Button
import dog.abcd.mvpdemo.base.IBaseView

interface IMainView : IBaseView {
    fun getBtnMain(): Button
    fun showToast(message: String)
}