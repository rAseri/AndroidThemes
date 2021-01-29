package ru.surinov.demo.themes.lib

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StyleRes
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment

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