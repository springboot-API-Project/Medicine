package com.medicine.check.service.blog;


import com.medicine.check.domain.blog.Blog;
import com.medicine.check.domain.blog.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    @Transactional(readOnly = true)
    public Blog findById(Long blog_id) {
        return blogRepository.findById(blog_id).get();
    }
}
