from django import forms
from webapp.models import Topic

class newTopicForm(forms.ModelForm):
    message=forms.CharField(widget=forms.Textarea(attrs={'placeholder':'what is on your mind?????'}),max_length=4000,help_text="the max length should be of 4000")

    class Meta:
        model=Topic
        fields=['subject','message']
