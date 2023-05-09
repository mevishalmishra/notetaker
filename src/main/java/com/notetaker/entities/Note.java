package com.notetaker.entities;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="note")
public class Note {
	
	@Id
	@Column(name = "note_id")
	private int noteId;
	
	
	@Column(name = "note_title")
	private String noteTitle;
	
	
	@Column(name = "note_content")
	private String noteContent;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "added_date")
	private Date addeDate;
	
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	
	
	public Date getAddeDate() {
		return addeDate;
	}
	public void setAddeDate(Date addeDate) {
		this.addeDate = addeDate;
	}

	
	
	public Note(int noteId, String noteTitle, String noteContent, Date addeDate) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.addeDate = addeDate;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteContent=" + noteContent + "]";
	}
	
	
	

}
