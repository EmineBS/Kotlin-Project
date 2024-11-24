import kotlinx.coroutines.test.runTest

@Test
fun @Test
fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = {
    val repository = NetworkMarsPhotosRepository(
        marsApiService = FakeMarsApiService()
    )assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
}