package com.springaop.test.service;
import com.springaop.test.model.entity.Notice;
import com.springaop.test.model.vo.NoticeInfo;
import com.springaop.test.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final NoticeRepository noticeRepository;

    /**
     * 공지사항 등록
     **/
    @Override
    public void setNotice(NoticeInfo noticeInfo) {

        Notice notice = new Notice();
        notice.setTitle(noticeInfo.getTitle());
        notice.setContent(noticeInfo.getContent());
        notice.setAuthor(noticeInfo.getAuthor());
        System.out.println("notice = " + notice);
        noticeRepository.save(notice);

    }
}
