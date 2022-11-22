package com.tedu.cloudnote.service;

import com.tedu.cloudnote.util.NoteResult;

public interface ShareService {
	public NoteResult<Object> 
			shareNote(String noteId);
}
