package spandroid.dev.kotlin.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.fragment_base_kotlin.*
import spandroid.dev.R

/**
 * This is the base fragment where all the fragments are extends this class
 * all the ready-made code are available here
 *
 */
abstract class BaseKotlinFragment : Fragment() {

    var mLayoutId: Int = -1

    companion object {
        val TAG = "BaseKotlinFragment"
    }


    /**
     * ************************* START OF OVERRIDED METHODS OF FRAGMENT  ****************************
     */

    /**
     * OnCreateView of Base Fragment
     * the method you initialize and create all your objects,
     * including your TextView), so it's not a matter of performance.
     *
     * After the onCreate() is called (in the Fragment), the Fragment's onCreateView() is called.
     * You can assign your View variables and do any graphical initialisations.
     * You are expected to return a  View from this method, and this is the main UI view,
     * but if your Fragment does not use any layouts or graphics,
     * you can return null (happens by default if you don't override).
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        var fragmentView: View = inflater.inflate(R.layout.fragment_base_kotlin, container, false)

        var frameLayoutRootBaseKotlin: FrameLayout = fragmentView.findViewById(R.id.frameLayoutRootBaseKotlin)

        inflater.inflate(getLayout(), frameLayoutRootBaseKotlin)

        initializeResources()
        setListeners()

        return fragmentView
    }


    protected fun getLayout(): Int {
        return mLayoutId
    }

    protected fun setLayout(layoutId: Int) {
        mLayoutId = layoutId
    }


    // protected abstract fun setLayoutFileName(layoutId: Int)

    protected abstract fun initializeResources()

    protected abstract fun setListeners()

    protected abstract fun getToolBarTitle(): String

    /**
     * ************************* END OF OVERRIDED METHODS OF FRAGMENT  ****************************
     */

    /**
     *loadingMessage is Option, u can pass message or not
     */
    fun showProgress(loadingMessage: String = "Loading") {
        tvMessageBaseFragment?.visibility = View.VISIBLE
        progressBaseFragment?.visibility = View.VISIBLE
        tvMessageBaseFragment?.text = loadingMessage
    }

    fun showError(errorMessage: String = "Error") {
        tvMessageBaseFragment?.visibility = View.VISIBLE
        tvMessageBaseFragment?.text = errorMessage
    }

    fun hideProgress() {
        tvMessageBaseFragment?.visibility = View.GONE
        progressBaseFragment?.visibility = View.GONE
    }

}
