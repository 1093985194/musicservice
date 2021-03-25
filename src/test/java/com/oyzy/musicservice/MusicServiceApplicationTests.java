package com.oyzy.musicservice;

import com.oyzy.musicservice.pojo.*;
import com.oyzy.musicservice.service.UserService;
import com.oyzy.musicservice.service.impl.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MusicServiceApplicationTests {

    @Autowired
//    private UserInListServiceImpl userInListService;
//    private SingerInSongServiceImpl singerInSongService;
//    private SongInListServiceImpl songInListService;
    private UserSericeImpl userSerice;
//    private SongServiceImpl songService;
//    private SongListServiceImpl songListService;
//    private MasterServiceImpl masterService;
//    private CommentServiceImpl commentService;

    //用户测试方法
    public void Usertest(){

//    @Test
//    public void addUsertest(){
//        User user = new User();
//        user.setUserId(1);
//        user.setName("oyzy");
//        user.setGender("男");
//        user.setPassword("Aa123123");
//        user.setContext("xxxx");
//        user.setImg("sjkfjsk");
//        user.setIssinger("F");
//        userSerice.addUser(user);
//    }
//
//    @Test
//    public void insertUsertest(){
//        User user = new User();
////        user.setUserId(3);
//        user.setName("BB");
//        user.setGender("男");
//        user.setPassword("Aa123123");
//        user.setIssinger("T");
//        userSerice.insertUser(user);
//    }
//
//    @Test
//    public void selectByNametest(){
//        String username = "oyzy";
//        List<User> userList = userSerice.selectByName(username);
//        System.out.println("userList="+userList);
//        User user = userList.get(0);
//        System.out.println(user.getName()+user.getUserId());
//    }
//
//    @Test
//    public void selectByPrimaryKeytest(){
//        int num = 3;
//        User user = userSerice.selectByPrimaryKey(num);
//        System.out.println("user="+user);
//    }
//
//    @Test
//    public void updateByPrimaryKeyWithBLOBstest(){
//        int num = 1;
//        User user = userSerice.selectByPrimaryKey(num);
//        user.setName("xxxxx");
//        int i = userSerice.updateByPrimaryKeyWithBLOBs(user);
//        System.out.println("user="+user+"i="+i);
//    }
//    @Test
//    public void deleteByPrimaryKeytest(){
//        int num = 1;
//        int i = userSerice.deleteByPrimaryKey(num);
//    }

//    @Test
//    public void allSingertest(){
//        List<User> allSinger = userSerice.allSinger("T");
//        System.out.println(allSinger);
//    }

//    @Test
//    public void genderSingertest(){
//        List<User> genderSinger = userSerice.genderSinger("T","男");
//        System.out.println(genderSinger);
//    }
    }
    //歌曲测试方法
    public void Songtest(){
//        @Test
//        public void insertSongtest(){
//            Song song = new Song();
//            song.setName("ee");
//            songService.insert(song);
//        }
//
//        @Test
//        public void selectByNametest(){
//            String name = "cc";
//            List<Song> songList = songService.selectByName(name);
//            System.out.println(songList);
//        }
//
//        @Test
//        public void deleteByPrimaryKeytest(){
//            int id = 1;
//            int delete = songService.deleteByPrimaryKey(id);
//        }
//
//        @Test
//        public void allSong(){
//            System.out.println(songService.allSong());
//        }

//        @Test
//        public void selectByUserId(){
//            System.out.println(songService.selectByUserId(2));
//        }
    }
    //歌单测试方法
    public void SongListtest(){
//        @Test
//        public void inserttest(){
//            Songlist songlist = new Songlist();
//            songlist.setTitle("BBB");
//            songlist.setIntroduction("好听的音乐");
//            songlist.setStyle("国语");
//
//            int insert = songListService.insert(songlist);
//
//        }
//
//        @Test
//        public void deleteByPrimaryKeytest(){
//            int key = 1;
//            int insert = songListService.deleteByPrimaryKey(key);
//        }
//
//        @Test
//        public void selectByNametest(){
//            String title = "信息";
//            List<Songlist> songlists = songListService.selectByName(title);
//            System.out.println(songlists);
//        }
//
//        @Test
//        public void selectByPrimaryKeytest(){
//            int i = 2;
//            Songlist songlist = songListService.selectByPrimaryKey(i);
//            System.out.println(songlist);
//        }
//
//        @Test
//        public void updateByPrimaryKeytest(){
//            int i = 2;
//            Songlist songlist = songListService.selectByPrimaryKey(i);
//            songlist.setTitle("xxxxx");
//            System.out.println(songListService.updateByPrimaryKey(songlist));
//        }
//
//        @Test
//        public void SonglistStyletest(){
//            String style = "国语";
//            List<Songlist> songlists = songListService.SonglistStyle(style);
//            System.out.println(songlists);
//        }
    }
    //管理员测试代码
    public void MasterTest(){
//        @Test
//        public void verifyPasswordtest(){
//            String name = "oyzy";
//            String password = "123";
//            boolean veritypasswd = masterService.veritypasswd(name, password);
//            System.out.println(veritypasswd);
//        }
//
//        @Test
//        public void insertTest(){
//            Master master = new Master();
//            master.setName("oyzy");
//            master.setPassword("123");
//            int insert = masterService.insert(master);
//            System.out.println(master);
//        }
    }
    //评论测试代码
    public void CommentTest(){
//        @Test
//        public void insert(){
//            Comment comment = new Comment();
//            comment.setContent("xxxxxxx");
//            comment.setSongId(3);
//            comment.setUserId(5);
//            comment.setGood(3);
//            int insert = commentService.insert(comment);
//            System.out.println(comment);
//        }
//
//        @Test
//        public void allComment(){
//            List<Comment> commentList = commentService.allComment();
//            System.out.println(commentList);
//        }
//
//        @Test
//        public void commentOfSongId(){
//            int i = 3;
//            List<Comment> commentList = commentService.commentOfSongId(i);
//            System.out.println(commentList);
//        }

//        @Test
//        public void commentOfUserId(){
//            int i = 3;
//            List<Comment> commentList = commentService.commentOfUserId(i);
//            System.out.println(commentList);
//        }
    }




//    @Test
//    public void insert(){
//        UserInList userInList = new UserInList();
//        userInList.setUserId(5);
//        userInList.setSonglistId(5);
//        int insert = userInListService.insert(userInList);
//    }
//    @Test
//    public void deleteBySongListid(){
//        int listid = 3;
//        songInListService.deleteBySongListid(listid);
//
//    }

    @Test
    public void test(){
        User user = userSerice.selectByPrimaryKey(3);
        user.setImg("img/user/1616580167564maomao.jpg");
        System.out.println(user);
        int i = userSerice.updateByPrimaryKeyWithBLOBs(user);
        System.out.println(i);
    }




}
