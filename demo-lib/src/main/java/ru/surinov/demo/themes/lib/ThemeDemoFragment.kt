package ru.surinov.demo.themes.lib

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.StyleRes
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import com.google.android.material.color.MaterialColors
import kotlinx.android.synthetic.main.fragment_theme_demo.*

class ThemeDemoFragment : Fragment() {

    companion object {
        private const val BUNDLE_THEME_RES = "ThemeDemoFragment.theme_res"

        fun newInstance(@StyleRes themRes: Int): Fragment {
            val fragmentArguments = Bundle()
            fragmentArguments.putInt(BUNDLE_THEME_RES, themRes)

            return ThemeDemoFragment().apply {
                arguments = fragmentArguments
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val themRes = arguments?.getInt(BUNDLE_THEME_RES)

        if (themRes == null) {
            return inflater.inflate(R.layout.fragment_theme_demo, container, false)
        }

        val themedInflater = applyThemeToInflater(inflater, themRes)
        return themedInflater.inflate(R.layout.fragment_theme_demo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val color = MaterialColors.getColor(requireActivity(), R.attr.themeIconColorOnWindowBackground, Color.BLACK)
        colorTestView.setBackgroundColor(color)
    }

    /**
     * Returns the color int for the provided theme color attribute, using the [Context] of the
     * current [this] view.
     */
    @ColorInt
    fun View.getColor(@AttrRes colorAttr: Int): Int {
        return MaterialColors.getColor(this, colorAttr)
    }

    private fun applyThemeToInflater(
        inflater: LayoutInflater,
        @StyleRes themeRes: Int
    ): LayoutInflater {

        // Create ContextThemeWrapper from the original Activity Context with the custom theme.
        val contextThemeWrapper: Context = ContextThemeWrapper(activity, themeRes)

        // Clone the inflater using the ContextThemeWrapper.
        return inflater.cloneInContext(contextThemeWrapper)
    }

}