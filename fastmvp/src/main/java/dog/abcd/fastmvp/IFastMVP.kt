package dog.abcd.fastmvp

import androidx.lifecycle.Lifecycle
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * <b>MVP Activity</b><br>
 * 通过实现这个接口来让自己的activity绑定presenter
 * ⚠️注意，不能直接在️activity子类中实现这个接口，
 * 正确做法应该是自定义一个BaseMvpActivity，这个类继承你本身的BaseActivity，并且实现这个接口
 * 例如：
 * abstract class BaseMvpActivity<K : IBaseView, T : BasePresenter<K>> : BaseActivity(),IMVP<K,T> {
 *
 *      override lateinit var presenter: T
 *
 *      override fun onCreate(savedInstanceState: Bundle?) {
 *          super.onCreate(savedInstanceState)
 *          //调用方法绑定presenter，并且会自动调用lifecycle.addObserver(presenter)，presenter能够感知生命周期
 *          bindPresenter()
 *      }
 *
 *      override fun lifecycle(): Lifecycle = lifecycle
 *
 * }
 *
 * @author michaellee <br> create at 2020/5/25 16:14
 */
interface IFastMVP<K : IFastView, T : FastPresenter<K>> {
    var presenter: T

    @Suppress("UNCHECKED_CAST")
    fun bindPresenter() {
        val clazz = getRealType()
        val constructor = clazz.getConstructor()
        val instance = constructor.newInstance()
        presenter = instance as T
        presenter.bind(this as K)
        lifecycle().addObserver(presenter)
    }

    // 使用反射技术得到T的真实类型
    private fun getRealType(): Class<*> {
        // 获取当前new的对象的泛型的父类类型
        val genericSuperclass: Type = this.javaClass.genericSuperclass!! as ParameterizedType
        val pt = genericSuperclass as ParameterizedType
        // 获取第二个类型参数的真实类型
        return pt.actualTypeArguments[1] as Class<*>
    }

    fun lifecycle(): Lifecycle

}