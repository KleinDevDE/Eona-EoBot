package de.eonadev.discord.eobot.api.commands.base;

import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.util.ArrayList;

public class EmbedListBuilder {
	private EmbedBuilder builder;
	private String left_title;
	private String right_title;
	private ArrayList<String> left = new ArrayList<>();
	private ArrayList<String> right = new ArrayList<>();
	
	
	public EmbedListBuilder(EmbedBuilder builder, String title_left, String title_right) {
		this.builder = builder;
		this.left_title = title_left;
		this.right_title = title_right;
	}
	
	public EmbedListBuilder addLine(String left, String right) {
		this.left.add(left);
		this.right.add(right);
		return this;
	}
	
	public EmbedBuilder build() {
		StringBuilder stringBuilder_left = new StringBuilder();
		StringBuilder stringBuilder_right = new StringBuilder();
		for (int count = 0; count <= left.size()-1; count++) {
			stringBuilder_left.append("\n").append(left.get(count));
			stringBuilder_right.append("\n").append(right.get(count));
		}
		builder.addInlineField(left_title, stringBuilder_left.toString());
		builder.addInlineField(right_title, stringBuilder_right.toString());
		return builder;
	}
}
