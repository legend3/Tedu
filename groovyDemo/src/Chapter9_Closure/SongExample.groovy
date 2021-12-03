package Chapter9_Closure
//Groovy的类调用
class SongExample {
    static void main(String[] args) {
        def song = new Song(name: "雨一直下",artist: "张宇", genre: "pop")
        println(song.toString())
        def song2 = new Song(name: "雨一直下", artist: "张宇")
        println song2
        def song3 = new Song()
        song3.name = "雨一直下"
        song3.artist = "张宇"
        song3.genre = "pop"
    }
}