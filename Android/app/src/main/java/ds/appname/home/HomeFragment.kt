package ds.appname.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ds.appname.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var artCategoryAdapter: ArtworkCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupArtCategoryAdapter()
    }

    private fun setupArtCategoryAdapter() {
        artCategoryAdapter = ArtworkCategoryAdapter(
            listOf("a", "b", "c"),
            object : ArtworkCategoryAdapter.ArtCategorySelectedListener {
                override fun onDirectItemClick() {
                    navigateToArtDetail()
                }

                override fun onMoreItemClick() {
                    navigateToArtList()
                }
            })

        mainCategoryArtRecycler.apply {
            adapter = artCategoryAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun navigateToArtDetail() {
        startActivity(Intent(context, ArtworkDetailActivity::class.java))
    }

    private fun navigateToArtList() {
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}
