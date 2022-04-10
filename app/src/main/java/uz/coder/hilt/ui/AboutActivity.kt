package uz.coder.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import com.squareup.picasso.Picasso
import uz.coder.hilt.R
import uz.coder.hilt.database.entity.NewsEntity
import uz.coder.hilt.databinding.ActivityAboutBinding
import uz.coder.hilt.models.Prevention

class AboutActivity : AppCompatActivity() {

    private val binding: ActivityAboutBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intExtra = intent.getBooleanExtra("key", false)

        binding.title.isSelected = true

        if (intExtra){
            val prevention = intent?.getSerializableExtra("prevention") as Prevention

            binding.image.setImageResource(prevention.image)
            binding.title.text = prevention.title
            binding.description.setText(R.string.musk)
        }else{
            val news = intent?.getSerializableExtra("news") as NewsEntity

            Picasso.get().load(news.imageUrl).into(binding.image)
            binding.title.text = news.title
            binding.description.text = news.description
        }


        binding.back.setOnClickListener {
            onBackPressed()
        }

    }
}