package com.codegym.lastwhisper.service.comment;

import com.codegym.lastwhisper.model.Comment;
import com.codegym.lastwhisper.model.Song;

public interface ICommentService extends IService<Comment> {

    Iterable<Comment> getAllByIdType(Long id);

}
