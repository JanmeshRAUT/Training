package Ecommerce;

public class Review {
    private String id;
    private String content;
    private int rating;
    private Product product;

    public Review(String id, String content, int rating) {
        this.id = id;
        this.content = content;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void SearchReviewbyProduct(Product product) {
        this.product = product;
    }
    
    public void toUpdateReviewbyId(String id, String newContent, int newRating) {
        if (this.id.equals(id)) {
            this.content = newContent;
            this.rating = newRating;
        }
    }
    
    @Override
    public String toString() {
        return "Review [id=" + id + ", content=" + content + ", rating=" + rating + ", getId()=" + getId()
                + ", getContent()=" + getContent() + ", getRating()=" + getRating() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
    
    
}
