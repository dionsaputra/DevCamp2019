package ds.appname.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ds.appname.R
import ds.appname.adapter.ArtCategoryAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var artCategoryAdapter: ArtCategoryAdapter

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
        artCategoryAdapter = ArtCategoryAdapter(
            listOf("a", "b", "c"),
            object : ArtCategoryAdapter.ArtCategorySelectedListener {
                override fun onDirectItemClick() {

                }

                override fun onMoreItemClick() {

                }
            })

        mainCategoryArtRecycler.apply {
            adapter = artCategoryAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}
