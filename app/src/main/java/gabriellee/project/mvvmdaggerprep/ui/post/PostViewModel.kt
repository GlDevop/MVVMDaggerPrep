package gabriellee.project.mvvmdaggerprep.ui.post

import android.arch.lifecycle.MutableLiveData
import gabriellee.project.mvvmdaggerprep.base.BaseViewModel
import gabriellee.project.mvvmdaggerprep.model.Post

class PostViewModel:BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }

}