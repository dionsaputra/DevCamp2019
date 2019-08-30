package ds.appname.artist

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter
import ds.appname.R

class ArtistShowcaseAdapter(private val data: List<String>, val context: Context) :
    CreativePagerAdapter {

    override fun instantiateHeaderItem(
        inflater: LayoutInflater,
        container: ViewGroup,
        position: Int
    ): View {
        val view = inflater.inflate(R.layout.item_showcase, container, false)
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
        return BitmapFactory.decodeResource(context.resources, R.drawable.art_1)
    }
}