package com.sim2g.icbt

import com.sim2g.icbt.network.Network
import junit.framework.Assert.assertTrue
import org.junit.Test

/**
 * Created by Farouk Sabiou on 2/15/22.
 */
class YearsEndpointTest {

    @Test
    fun getYears() {
        val response = Network.api.getAllYears().execute()
        assertTrue(response.isSuccessful)
    }
}