package fangcheng.springframework.lab.springboot.mybatis.h2.mapper;



import java.util.List;

public interface NameMapper {
	List<String>  selectAllNames();
}