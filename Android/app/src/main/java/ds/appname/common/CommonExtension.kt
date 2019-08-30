package ds.appname.common

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(resourceId: Int) {
    Glide.with(this).load(resourceId).into(this)
}

fun ImageView.load(imageUrl: String) {
    Glide.with(this).load(imageUrl).into(this)
}