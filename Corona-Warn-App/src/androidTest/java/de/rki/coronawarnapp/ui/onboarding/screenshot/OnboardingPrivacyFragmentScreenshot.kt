package de.rki.coronawarnapp.ui.onboarding.screenshot

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.rki.coronawarnapp.R
import de.rki.coronawarnapp.ui.onboarding.OnboardingPrivacyFragment
import de.rki.coronawarnapp.ui.onboarding.OnboardingPrivacyViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import testhelpers.BaseUITest
import testhelpers.Screenshot
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.locale.LocaleTestRule

@Screenshot
@RunWith(AndroidJUnit4::class)
class OnboardingPrivacyFragmentScreenshot : BaseUITest() {

    @MockK lateinit var viewModel: OnboardingPrivacyViewModel

    @Rule
    @JvmField
    val localeTestRule = LocaleTestRule()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)

        setupMockViewModel(object : OnboardingPrivacyViewModel.Factory {
            override fun create(): OnboardingPrivacyViewModel = viewModel
        })
    }

    @After
    fun teardown() {
        clearAllViewModels()
    }

    @Test
    fun capture_screenshot() {
        launchFragmentInContainer<OnboardingPrivacyFragment>(themeResId = R.style.AppTheme)
            .onFragment {
                Screengrab.screenshot(OnboardingPrivacyFragment::class.simpleName)
            }
    }
}
