package com.example.blogging_platform.utilities;

import com.example.blogging_platform.models.Tag;
import com.example.blogging_platform.repositories.TagRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TagMapper {
    private TagRepository tagRepository;

    public TagMapper(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    public List<Tag> toTagList(List<String> tagNames){
        List<Tag> tagList = new ArrayList<Tag>();
        for(String tagName: tagNames){
            Optional<Tag> tagOptional = tagRepository.findByName(tagName);
            Tag tag = null;
            if(tagOptional.isEmpty()){
                tag = tagRepository.save(new Tag(tagName));
            }
            if(tag == null){
                tag = tagOptional.get();
            }
            tagList.add(tag);
        }
        return tagList;
    }
}
