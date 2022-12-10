package com.izlam.taskhamserv.Ui

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.AppBarLayout
import com.izlam.taskhamserv.R
import com.izlam.taskhamserv.databinding.ActivityMotionlayoutintegrationsBinding

class motionlayoutintegrationsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMotionlayoutintegrationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.goEdgeToEdge()
        binding= ActivityMotionlayoutintegrationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listener = AppBarLayout.OnOffsetChangedListener { appBar, verticalOffset ->
            // convert offset into % scrolled
            val seekPosition = -verticalOffset / appBar.totalScrollRange.toFloat()
            // inform both both MotionLayout and CutoutImage of the animation progress.
            binding.motionLayout.progress = seekPosition
//            binding.background.translationProgress = (100 * seekPosition).toInt()
        }
        binding.appbarLayout.addOnOffsetChangedListener(listener)

        // get the collapsed height from the motion layout specified in XML
        val desiredToolbarHeight = binding.motionLayout.minHeight
        ViewCompat.setOnApplyWindowInsetsListener(binding.motionLayout) { _, insets: WindowInsetsCompat ->
            // resize the motionLayout in collapsed state to add the needed inset height
            val insetTopHeight = insets.systemWindowInsetTop
            binding.motionLayout.minimumHeight = desiredToolbarHeight + insetTopHeight

            // modify the end ConstraintSet to set a guideline at the top and bottom of inset
            val endConstraintSet = binding.motionLayout.getConstraintSet(R.id.collapsed)
            // this guideline is the bottom of the inset area
            endConstraintSet.setGuidelineEnd(R.id.inset, desiredToolbarHeight)
            // this guideline is the top of the inset area (top of screen)
            endConstraintSet.setGuidelineEnd(R.id.collapsed_top, desiredToolbarHeight + insetTopHeight)

            // set the guideline for the start constraint set as well
            val startConstraintSet = binding.motionLayout.getConstraintSet(R.id.expanded)
            startConstraintSet.setGuidelineBegin(R.id.collapsed_top, insetTopHeight)

            insets
        }
    }
    private fun Window.goEdgeToEdge() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
        }
        // TODO: replace this with non-deprecated edge to edge option
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
}