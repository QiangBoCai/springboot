<#include "include/macros.ftl">

<@header title="My音乐馆" keywords="80后,90后,轻音乐,纯音乐,节奏,旋律,治愈" description="My音乐馆">
</@header>

<div id="background">
    <canvas id="canvas"></canvas>
</div>
<div class="box">
    <div id="top">My音乐馆&nbsp;&nbsp;|&nbsp;&nbsp;肖涛的博客</div>
    <div id="player">
        <div class="cover"></div>
        <div class="ctrl">
            <div class="tag">
                <strong>Title</strong> <span class="artist">Artist</span> <span class="album">Album</span>
            </div>
            <div class="control">
                <div class="left">
                    <div class="rewind icon"></div>
                    <div class="playback icon"></div>
                    <div class="fastforward icon"></div>
                </div>
                <div class="volume right">
                    <div class="mute icon left"></div>
                    <div class="slider left">
                        <div class="pace"></div>
                    </div>
                </div>
            </div>
            <div class="progress">
                <div class="slider">
                    <div class="loaded"></div>
                    <div class="pace"></div>
                </div>
                <div class="timer left">0:00</div>
                <div class="right">
                    <div class="repeat icon"></div>
                    <div class="shuffle icon"></div>
                </div>
            </div>
        </div>
    </div>
    <div id="lyr"></div>
    <ul id="playlist"><strong><span>歌曲列表正在加载中...</span></strong></ul>
</div>

<@footer>
    <script src="/js/zhyd.music.core.js?v=1.0.1" type="text/javascript"></script>
    <script>
        $('.goTop').toTop();
        var ptop = $('#player').position().top;
        //157
        $(window).scroll(function () {
            var tops = $(this).scrollTop();
            if (tops - ptop > 0) {
                $('#player').css({'top': tops - ptop});
                $('#player').css({'background': 'rgba(0, 0, 0, 0.8)'});
            } else {
                $('#player').css({'top': '0'});
                $('#player').css({'background': 'rgba(255, 255, 255, 0.15)'});
            }
        })
    </script>
</@footer>