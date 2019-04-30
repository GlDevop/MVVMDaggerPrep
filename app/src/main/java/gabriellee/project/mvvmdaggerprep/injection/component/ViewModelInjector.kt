package gabriellee.project.mvvmdaggerprep.injection.component

import dagger.Component
import gabriellee.project.mvvmdaggerprep.injection.module.NetworkModule
import gabriellee.project.mvvmdaggerprep.ui.post.PostListViewModel
import javax.inject.Singleton

/*
Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the spcified PostListViewModel.
     * @param postlistViewModel PostListViewModel in which to inject the dependencies
     */

    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}