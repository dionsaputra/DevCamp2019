package ds.appname.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ds.appname.R
import ds.appname.arengine.PermissionCheckActivity
import ds.appname.artist.ArtistProfileActivity
import kotlinx.android.synthetic.main.activity_art_detail.*

class ArtworkDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art_detail)

        buyArtworkButton.setOnClickListener { showDialogBuyArtworks() }
        hireArtistButton.setOnClickListener { showDialogHireArtist() }
        showArModeButton.setOnClickListener { showArMode() }
        artistAvatar.setOnClickListener { navigateToArtistProfile() }
    }

    private fun showDialogBuyArtworks() {
        BuyArtworksFragment().show(
            supportFragmentManager,
            BuyArtworksFragment::class.java.simpleName
        )
    }

    private fun showDialogHireArtist() {
        HireArtistFragment().show(
            supportFragmentManager,
            HireArtistFragment::class.java.simpleName
        )
    }

    private fun showArMode() {
        startActivity(Intent(this, PermissionCheckActivity::class.java))
    }

    private fun navigateToArtistProfile() {
        startActivity(Intent(this, ArtistProfileActivity::class.java))
    }
}
