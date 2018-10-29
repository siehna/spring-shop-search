package handson.example.springshopsearch.model.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
	//主キーの指定
	@Id
	//連番でIDを入れてくれる
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //カラム名を明示的に指定
	@Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;

    //最小値の意味
    @Min(value = 0)
    @Column(name = "price")
    public int price;

    @Column(name = "description", columnDefinition = "TEXT")
    public String description;
}
