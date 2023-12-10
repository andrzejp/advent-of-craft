package blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.BDDAssertions.catchException;
import static org.assertj.core.api.BDDAssertions.then;

class ArticleTests {

    public static final String TEXT = "Amazing article !!!";
    public static final String AUTHOR = "Pablo Escobar";
    private static final LocalDate TODAY = LocalDate.of(2023, 12, 4);
    private Article article;

    @BeforeEach
    void setUp() {
        article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
    }

    @Test
    void should_add_new_comment_to_article_with_no_comments() throws CommentAlreadyExistException {
        article.addComment(TEXT, AUTHOR, TODAY);

        then(article.getComments())
                .hasSize(1)
                .first()
                .extracting(Comment::author, Comment::text, Comment::creationDate)
                .containsExactly(AUTHOR, TEXT, TODAY);
    }

    @Test
    void should_add_new_comment_to_article_with_existing_comment() throws CommentAlreadyExistException {
        String newText = "new text";
        String newAuthor = "new author";
        LocalDate newDate = LocalDate.now();
        article.addComment(newText, newAuthor, newDate);

        article.addComment(TEXT, AUTHOR, TODAY);

        then(article.getComments())
                .hasSize(2)
                .last()
                .extracting(Comment::author, Comment::text, Comment::creationDate)
                .containsExactly(AUTHOR, TEXT, TODAY);
    }

    @Test
    void should_fail_to_add_the_same_comment_twice() throws CommentAlreadyExistException {
        article.addComment(TEXT, AUTHOR, TODAY);

        Exception exception = catchException(() -> article.addComment(TEXT, AUTHOR, TODAY));

        then(exception)
                .isInstanceOf(CommentAlreadyExistException.class);
    }
}
