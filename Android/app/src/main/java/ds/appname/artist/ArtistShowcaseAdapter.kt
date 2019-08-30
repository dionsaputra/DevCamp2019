package ds.appname.artist

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter
import ds.appname.R
import ds.appname.common.load
import kotlinx.android.synthetic.main.item_showcase.view.*

class ArtistShowcaseAdapter(private val data: List<String>, val context: Context) :
    CreativePagerAdapter {

    private var images = listOf<Int>(R.drawable.art_1, R.drawable.art_2, R.drawable.art_3)

    override fun instantiateHeaderItem(
        inflater: LayoutInflater,
        container: ViewGroup,
        position: Int
    ): View {
        val view = inflater.inflate(R.layout.item_showcase, container, false)
        view.contentImage.load(images[position])
        return view
    }

    override fun instantiateContentItem(
        inflater: LayoutInflater,
        container: ViewGroup,
        position: Int
    ): View {
        // Inflate the header view layout
        val contentRoot = inflater.inflate(R.layout.item_showcase, container, false)
        contentRoot.visibility = View.GONE
        return contentRoot
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun isUpdatingBackgroundColor(): Boolean {
        return true
    }

    override fun requestBitmapAtPosition(position: Int): Bitmap? {
        // Return the bitmap used for the position
        return BitmapFactory.decodeResource(context.resources, images[position])
    }
}