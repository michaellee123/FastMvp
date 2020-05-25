package dog.abcd.mvpdemo.view.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import dog.abcd.mvpdemo.R
import dog.abcd.mvpdemo.base.BaseMvpActivity
import dog.abcd.mvpdemo.presenter.TestPresenter
import dog.abcd.mvpdemo.view.ITestView
import kotlinx.android.synthetic.main.activity_text.*

class TestActivity : BaseMvpActivity<ITestView, TestPresenter>(), ITestView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun layoutId(): Int {
        return R.layout.activity_text
    }

    override fun getTextView(): TextView {
        return textView
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
