package dog.abcd.mvpdemo.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import dog.abcd.mvpdemo.R
import dog.abcd.mvpdemo.base.BaseMvpActivity
import dog.abcd.mvpdemo.presenter.MainPresenter
import dog.abcd.mvpdemo.presenter.MainPresenter2
import dog.abcd.mvpdemo.view.IMainView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : BaseMvpActivity<IMainView, MainPresenter>(),IMainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun getBtnMain(): Button {
        return btnMain
    }

    override fun showToast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
