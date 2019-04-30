package gabriellee.project.mvvmdaggerprep

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import gabriellee.project.mvvmdaggerprep.injection.ViewModelFactory
import gabriellee.project.mvvmdaggerprep.ui.post.PostListViewModel

class PostListActivity : AppCompatActivity() {

    private lateinit var binding: gabriellee.project.mvvmdaggerprep.databinding.ActivityPostListBinding
    private lateinit var viewModel: PostListViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_list)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(PostListViewModel::class.java)
        binding.viewModel = viewModel
    }

    private fun showError(@StringRes errorMessage:Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()

    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}
