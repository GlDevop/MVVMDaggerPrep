package gabriellee.project.mvvmdaggerprep.ui.post

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import gabriellee.project.mvvmdaggerprep.R
import gabriellee.project.mvvmdaggerprep.model.Post

class PostListAdapter: RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    private lateinit var postList:List<Post>

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostListAdapter.ViewHolder {
        val binding: gabriellee.project.mvvmdaggerprep.databinding.ItemPostBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            R.layout.item_post, p0, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(postList[p1])
    }

    fun updatePostList(postList:List<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: gabriellee.project.mvvmdaggerprep.databinding.ItemPostBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = PostViewModel()

        fun bind(post:Post){
            viewModel.bind(post)
            binding.viewModel = viewModel
        }
    }

}