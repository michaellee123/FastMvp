package dog.abcd.mvpdemo.view

import android.widget.TextView
import dog.abcd.mvpdemo.base.IBaseView

interface ITestView : IBaseView {
    fun getTextView(): TextView
    fun showToast(message: String)
}