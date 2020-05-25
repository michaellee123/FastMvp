package dog.abcd.mvpdemo.base

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import dog.abcd.fastmvp.IFastView

interface IBaseView : IFastView {
    fun getContext(): Context?
    fun getLifecycleOwner(): LifecycleOwner?
    fun getBundle(): Bundle?
    fun finishActivity() {}
}