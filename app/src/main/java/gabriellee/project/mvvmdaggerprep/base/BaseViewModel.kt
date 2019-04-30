package gabriellee.project.mvvmdaggerprep.base

import android.arch.lifecycle.ViewModel
import gabriellee.project.mvvmdaggerprep.injection.component.DaggerViewModelInjector
import gabriellee.project.mvvmdaggerprep.injection.component.ViewModelInjector
import gabriellee.project.mvvmdaggerprep.injection.module.NetworkModule
import gabriellee.project.mvvmdaggerprep.ui.post.PostListViewModel

abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }

}