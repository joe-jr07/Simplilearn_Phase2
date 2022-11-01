package model;

public interface PostDAO {
	int addPost(Post post);
	int updatePost(Post post);
	int deletePost(Post post);
}
