package com.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tedu.cloudnote.dao.NoteDao;
import com.tedu.cloudnote.dao.ShareDao;
import com.tedu.cloudnote.entity.Note;
import com.tedu.cloudnote.entity.Share;
import com.tedu.cloudnote.util.NoteResult;
import com.tedu.cloudnote.util.NoteUtil;

@Service("shareService")
public class ShareServiceImpl implements ShareService{
	@Resource
	private ShareDao shareDao;
	@Resource
	private NoteDao noteDao;
	
	public NoteResult<Object> shareNote(
			String noteId) {
		//向分享cn_share表插入记录
		Share share = new Share();
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);//分享ID
		share.setCn_note_id(noteId);//笔记ID
		//根据笔记ID查找标题和内容
		Note note = noteDao.findById(noteId);
		share.setCn_share_title(
			note.getCn_note_title());//分享笔记标题
		share.setCn_share_body(
			note.getCn_note_body());//分享笔记内容
		shareDao.save(share);//保存分享记录
		//TODO 修改cn_note表type_id值,设置成分享类型
		
		//创建返回结果
		NoteResult<Object> result = 
				new NoteResult<Object>();
		result.setStatus(0);
		result.setMsg("分享笔记成功");
		return result;
	}

}
