
package com.shashi.shiva.codechallengevirtusa.data.network

import com.shashi.shiva.codechallengevirtusa.di.EmptyString
import javax.inject.Inject


class ApiHeader @Inject constructor(val publicApiHeader: PublicApiHeader, val protectedApiHeader: ProtectedApiHeader) {

    class PublicApiHeader  @Inject constructor( @EmptyString var apiKey: String)

    class ProtectedApiHeader  @Inject constructor(@EmptyString var apiKey: String, @EmptyString var userId: String?, @EmptyString var accessToken: String?)
}